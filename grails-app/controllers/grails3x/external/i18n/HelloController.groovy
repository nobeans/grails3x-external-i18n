package grails3x.external.i18n

import grails.converters.JSON

class HelloController {

    def index() {
        // 実際はログイン時のユーザ情報などを使うイメージ。
        def user = [name: "i18n"]

        // Grailsではコントローラでもタグライブラリをメソッドのように使える。
        // 以下は <g:message code="hello" args="[user.name]" /> と同じ。
        render([hello: message(code: "hello", args: [user.name])] as JSON)
    }
}
