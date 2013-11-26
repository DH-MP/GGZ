$ ->
  # Initialize Stellar js
  $.stellar
    horizontalScrolling: false
    verticalOffset: 40

  $('flippant-back flippant-modal-dark flipper flipped').blurjs
    source: 'body'
    radius: 5

  $('.flippable img').on "click", ->
    back = flippant.flip($(this).get(0), game_modal_template, "modal")
    gameId = $(this).parents('div.flippable').data("id")
    $.getJSON "/game.do?api=true&id=#{gameId}", (data) ->
      console.log data

    $(".close-flippant").on "click", (e) ->
      e.preventDefault()
      back.close()

game_modal_template = """
                      <div class="container">
                      <h1>Game Title</h1>
                      <hr />
                      <p>Description
                      </p>
                      <button class="btn btn-default btn-danger close-flippant"><span class="glyphicon glyphicon-remove"></span></span>
                      </div>
                      """



