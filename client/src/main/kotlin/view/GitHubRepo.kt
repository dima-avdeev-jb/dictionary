package view

import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.html.js.onClickFunction
import github.GitHubRepo
import react.*
import react.dom.button
import styled.StyleSheet
import styled.css
import styled.styledDiv

object GigHubRepoStyles : StyleSheet("PostStyles", isStatic = true) {
    val noComments by css {
        marginBottom = 8.px
    }

    val body by css {
        +noComments

        paddingBottom = 8.px
        borderBottom(1.px, BorderStyle.solid, Color("#000").withAlpha(0.1))
    }

    val comment by css {
        +body

        lastOfType {
            borderBottomStyle = BorderStyle.none
        }
    }
}

interface GitHubRepoProps : RProps {
    var gitHubRepo: GitHubRepo
    var onMoreComments: () -> Unit
}

class GitHubRepoState : RState {
    var noMore: Boolean = false
    var loading: Boolean = false
}

class GitHubRepoView : RComponent<GitHubRepoProps, GitHubRepoState>() {
    private val repo
        get() = props.gitHubRepo

    private val commitLogs
        get() = props.gitHubRepo.commitLogs

    init {
        state = GitHubRepoState()
    }

    override fun componentDidUpdate(prevProps: GitHubRepoProps, prevState: GitHubRepoState, snapshot: Any) {
        if (state.loading && prevProps != props) {
            setState {

                noMore = prevProps.gitHubRepo.commitLogs.size == props.gitHubRepo.commitLogs.size
                loading = false
            }
        }
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                padding(all = 10.px)
                backgroundColor = Color.lightGray
            }

            repoView(props.gitHubRepo) {
                css {
                    marginBottom = 16.px
                }
            }

            styledDiv {
                css {
                    if (commitLogs.isNotEmpty()) {
                        +GigHubRepoStyles.body
                    } else {
                        +GigHubRepoStyles.noComments
                    }
                }
                +props.gitHubRepo.description
            }

            commitLogs.forEach {
                commentView(it) {
                    css {
                        +GigHubRepoStyles.comment
                    }
                }
            }

            if (!state.noMore) {
                button {
                    attrs {
                        onClickFunction = {
                            setState {
                                loading = true
                            }
                            props.onMoreComments()
                        }
                    }

                    +"Load commit history"
                }
            }
        }
    }
}

fun RBuilder.gitHubRepoView(
    post: GitHubRepo,
    onLoadCommits: () -> Unit
) {
    child(GitHubRepoView::class) {
        attrs.gitHubRepo = post
        attrs.onMoreComments = onLoadCommits
    }
}