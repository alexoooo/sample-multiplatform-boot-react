package view

import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.div


class CounterComponent: RComponent<RProps, CounterComponent.State>() {
    class State: RState {
        var count = 0
    }


    init {
        state = State()
    }


    private fun onClick(event: Event) {
        console.log("handling click", event)
        setState {
            count += 1
        }
    }


    override fun RBuilder.render() {
        div {
            attrs {
                onClickFunction = ::onClick
            }

            +"click count: ${state.count}"
        }
    }
}