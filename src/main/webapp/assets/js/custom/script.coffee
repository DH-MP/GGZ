$ ->
  # Initialize Stellar js
  $.stellar
    horizontalScrolling: false
    verticalOffset: 40

  # Apply flipant to flippable item
  $('.flippable h2').on "click", ->
    back = flippant.flip($(this).parents('.flippable').get(0), "I am the back content", "modal")


