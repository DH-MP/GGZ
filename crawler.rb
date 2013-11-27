#!/usr/bin/env ruby
require 'rubygems'
require 'awesome_print'
require 'pry-clipboard'
require 'active_record'
require 'mysql2'
require 'json'
require 'hashie'
require 'httparty'
require 'open-uri'

api_key = "c6228329f1f67da8421899c69ba7694d20991eca"
api_url = "http://giantbomb.com/api/search"
api_format = "json"
api_resource_type = "game"
api_sort = "original_release_date:desc"
api_field = [ "api_detail_url", "deck", "description", "developers", "id",
              "image", "name", "original_release_date", "original_game_rating",
              "platforms" ]

query = URI::encode ARGV.join(" ")
query_url = "#{api_url}?api_key=#{api_key}&query=#{query}&format=#{api_format}&resources=#{api_resource_type}&field_list=#{api_field.join(',')}&sort=#{api_sort}"
puts query_url

ActiveRecord::Base.establish_connection(
  :adapter => "mysql",
  :host => "localhost",
  :database => "soen387",
  :user => "root",
  :password => "root"
)

class Game < ActiveRecord::Base
  has_one :image
  has_and_belongs_to_many :platforms
  has_and_belongs_to_many :developers
  has_and_belongs_to_many :pg_ratings
end

class Platform < ActiveRecord::Base
  has_and_belongs_to_many :games
end

class Developer < ActiveRecord::Base
  has_and_belongs_to_many :games
end

class PgRating < ActiveRecord::Base
  has_and_belongs_to_many :games
end

class Image < ActiveRecord::Base
  belongs_to :game
end

def from_json_response(hash)
  puts "Saving to database #{hash.id} #{hash.name}"
  return if hash.id.nil?
  g = Game.new
  g.price = 59.99
  g.rating = 0
  g.api_id = hash.id || 0
  g.name = hash.name || "Unknown"
  g.release_date = hash.original_release_date || Time.now
  g.deck = hash.deck || "Unknown"
  g.description = hash.description || "No description"
  g.api_detail_url = hash.api_detail_url || ""

  img = Image.new
  unless hash.image.nil?
    img.tiny_url = hash.image.tiny_url || ""
    img.medium_url = hash.image.thumb_url || ""
    img.large_url = hash.image.small_url || ""
    g.image = img
  end


  unless hash.original_game_rating.nil?
    hash.original_game_rating.each do |r|
      rating = PgRating.find_by(name: r.name) || PgRating.new
      rating.name = r.name
      g.pg_ratings << rating
    end
  end

  unless hash.platforms.nil?
    hash.platforms.each do |p|
      platform = Platform.find_by(name: p.name) || Platform.new
      platform.name = p.name
      g.platforms << platform
    end
  end

  hash.developers.each do |d|
    developer = Developer.find_by(name: d.name) || Developer.new
    developer.name = p.name
    g.developers << developer
  end unless hash.developers.nil?

  g.save
  g.image_id = g.image.id
  g.save
end

#file = File.open("./src/main/resources/response-sample.json", "r")
#hash = JSON.parse file.read
#file.close
response = HTTParty.get query_url
hash = JSON.parse response.body

obj = Hashie::Mash.new hash
obj.results.each do |g|
  # puts "#{g.id} #{g.name}"
  if Game.where(api_id: g.id).empty?
    from_json_response g
  end
end

from_json_response(obj)

