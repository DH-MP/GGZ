$ ->
  # Initialize Stellar js
  $.stellar
    horizontalScrolling: false
    verticalOffset: 40

  $('flippant-back flippant-modal-dark flipper flipped').blurjs
    source: 'body'
    radius: 5

  $('.flippable img').on "click", ->
    $thisImg = $(this)
    gameId = $(this).parents('div.flippable').data("id")
    $.getJSON "/game.do?api=true&id=#{gameId}", (data) ->
      game_modal_template = $('<div/>',
        class: 'container')
      .append(
        $('<img/>',
            "class": "box-art-container-large"
            "src": "#{data.image_url}"
            "style": "float: right")
        .add($('<h1/>',
          "html": "#{data.title}")
          .append($('<span/>',
              "class": "label label-success label-large"
              "style": "margin-left: 20px"
              "html": "$ #{data.price}")))
        .add($('<hr/>'))
        .add($('<div/>')
          .append($('<p/>',
            "html": "#{data.deck}")))
        .add($('<button/>',
          "class": "btn btn-default btn-danger close-flippant")
          .append(
            $('<span/>',
              "class": "glyphicon glyphicon-remove"))))

      back = flippant.flip($thisImg.get(0), game_modal_template.html(), "modal")
      $(".close-flippant").on "click", (e) ->
        e.preventDefault()
        back.close()

