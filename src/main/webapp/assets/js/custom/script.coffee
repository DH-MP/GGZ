$ ->
  # Initialize Stellar js
  $.stellar
    horizontalScrolling: false
    verticalOffset: 40

  # Apply flipant to flippable item
  $('.flippable img').on "click", ->
    back = flippant.flip($(this).get(0), "I am the back content", "modal")


