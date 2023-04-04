package DKFDS.komponenter
import scalatags.Text.all.*
import scalatags.Text.all.tag as tagg
import DKFDS.komponenter.Komponent.given_Conversion_Komponent2_Tag

case class Tabelvælger(override val anId: String, aLabel: String, defaultText: String) extends Komponent2:
  val table: CheckboxTabel = CheckboxTabel.loading(s"$anId-table")
  val modalId: String = s"$anId-modal"
  override val tag: Tag = div(cls := "from-group")(
    label(cls := "form-label", `for` := anId)(aLabel),
    div(
      a(href := "javascript:void(0);", cls := "function-link", id := anId)(defaultText)
    ),
    // Modal for selecting the options
    div(
      cls := "fds-modal",
      id := modalId,
      attr("aria-hidden") := true,
      role := "dialog",
      attr("aria-modal") := true,
      aria.labelledby := "modal-id-1-title")(  // TODO
      div(cls := "modal-content", width := "auto")(
        div(cls := "modal-header")(
          h2(cls := "modal-title", id := s"modal-$anId-title")(aLabel),
          button(cls := "modal-close function-link", data("modal-close").empty)(
            tagg("svg")(cls := "icon-svg", attr("focusable") := false, aria.hidden := true)(
              tagg("use")(attr("xlink:href") := "img/all-svg-icons.svg#close")
            )("Luk")
          )
        ),
        div(cls := "modal-body")(
          table
        )
      )
    )
  )
