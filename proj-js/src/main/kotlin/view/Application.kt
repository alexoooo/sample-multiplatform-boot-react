package view

import contrib.ringui.header.ringHeader
import contrib.ringui.header.ringLogo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.css.marginBottom
import kotlinx.css.padding
import kotlinx.css.paddingLeft
import kotlinx.css.px
import react.*
import styled.StyleSheet
import styled.css
import styled.styledA
import styled.styledDiv
import kotlin.random.Random

val jetbrainsLogo = kotlinext.js.require("@jetbrains/logos/jetbrains/jetbrains-simple.svg")

private object ApplicationStyles : StyleSheet("ApplicationStyles", isStatic = true) {
    val wrapper by css {
        padding(32.px, 16.px)
    }

    val post by css {
        marginBottom = 32.px
    }
}

interface ApplicationProps : RProps {
    var coroutineScope: CoroutineScope
}

class ApplicationState : RState {
//    var postWithComments: List<PostWithComments> = emptyList()
//    var users: List<User> = emptyList()
}

class ApplicationComponent : RComponent<ApplicationProps, ApplicationState>() {
    init {
        state = ApplicationState()
    }

    private val coroutineContext
        get() = props.coroutineScope.coroutineContext

    override fun componentDidMount() {
//        val postWithCommentsService = PostWithCommentsService(coroutineContext)
//        val userService = UserService(coroutineContext)
//
//        props.coroutineScope.launch {
//            val posts = postWithCommentsService.getPostsWithComments()
//
//            setState {
//                postWithComments += posts
//            }
//
//            // Parallel coroutines execution example
//            val userIds = posts.map { it.post.userId }.toSet()
//            val users = userIds
//                .map { async { userService.getUser(it) } }
//                .map { it.await() }
//
//            setState {
//                this.users = users
//            }
//        }
    }

    override fun RBuilder.render() {
        ringHeader {
            styledA("/") {
                css {
                    specific {
                        paddingLeft = 48.px
                    }
                }
                ringLogo {
                    attrs {
                        className = "logo"
                        glyph = jetbrainsLogo
                    }
                }
                +"hello world!"
            }
        }

        styledDiv {
            css {
                +ApplicationStyles.wrapper
            }
            +"foo"
        }
    }
}
