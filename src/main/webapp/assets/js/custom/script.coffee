$ ->
  # Initialize Stellar js
  $.stellar
    horizontalScrolling: false
    verticalOffset: 40

  $("#cart-box").popover()

  $('.list-group-item').hover((-> $(this).addClass "active"), (-> $(this).removeClass "active"))
  $('flippant-back flippant-modal-dark flipper flipped').blurjs
    source: 'body'
    radius: 5

  $('.flippable img, a.flippable').on "click", (e) ->
    e.preventDefault()
    $thisImg = $(this)
    gameId = $(this).parents('.flippable').data("id") || $(this).data("id")
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
            "class": "btn btn-large btn-default btn-success")
          .html("Add to Cart")
          .append(
              $('<span/>',
                "class": "glyphicon glyphicon-shopping-cart")))
        .add($('<button/>',
            "class": "btn btn-default btn-danger close-flippant")
          .html("Close")
          .append(
            $('<span/>',
              "class": "glyphicon glyphicon-remove"))))

      back = flippant.flip($thisImg.get(0), game_modal_template.html(), "modal")
      $(".close-flippant").on "click", (e) ->
        e.preventDefault()
        back.close()

