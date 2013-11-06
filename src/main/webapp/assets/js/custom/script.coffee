$ ->
  # Initialize Stellar js
  $.stellar
    horizontalScrolling: false
    verticalOffset: 40

  # Apply flipant to flippable item
  $('.flippable img').on "click", ->
    back = flippant.flip($(this).get(0), game_modal_template, "modal")


game_modal_template = """
                      <div class="container">
                      <h1>Game Title</h1>
                      <hr />
                      <p>
                      Integer porta nulla eget enim tincidunt, in suscipit velit ultrices. Morbi at massa ligula. Cras scelerisque molestie eros sit amet scelerisque. Cras tempus accumsan vestibulum. Nullam congue vestibulum justo, sed tempus felis ornare id. Sed tristique et justo non molestie. Aliquam libero dui, rutrum quis interdum a, facilisis posuere diam. Nam sit amet sapien enim. Morbi viverra laoreet magna, sit amet interdum ligula suscipit et. Nunc molestie nisi vitae orci mattis laoreet. Praesent rutrum nibh vel orci commodo, a dapibus magna blandit. Vivamus tincidunt quam dolor, vitae pellentesque felis dignissim vel. Ut placerat rutrum dui, id fermentum nibh vehicula ut. Cras accumsan tellus in nisi rutrum, eget placerat diam adipiscing.
                      </p>
                      <p>
                      Suspendisse eget dolor elit. Pellentesque congue ante vel mattis auctor. Suspendisse mollis nisl sem. Donec placerat sed turpis eget rutrum. In eu felis et leo semper aliquet. Proin id ante venenatis lectus interdum elementum. Etiam nec libero nunc.
                      </p>
                      </div>
                      """



