import org.grails.spring.context.support.ReloadableResourceBundleMessageSource
import grails.util.Holders

class BootStrap {

    def messageSource

    def init = { servletContext ->
        setupAdditionalMessageSources(messageSource)
        println "messageSource: " + messageSource.dump() // for DEBUG
    }

    def destroy = {
    }

    // Grails 3.xではPluginAwareResourceBundleMessageSource#afterPropertiesSet()がbasenamesを自動再構築してしまうため、
    // このようにビーンの初期化後のBootStrapなどのタイミングで、設定を反映する必要がある。
    private setupAdditionalMessageSources(messageSource) {
        // 追加ファイル内にエントリが見つからなかったキーは、最終的にGrailsが自動的にセットアップする標準方法で解決する。
        // このためにprivateフィールドになっているオリジナル設定を強引ではあるが取得しておく。
        List originalBasenames = ReloadableResourceBundleMessageSource.getDeclaredField("basenames").with { field ->
            field.accessible = true
            field.get(messageSource)
        }

        // 設定を変更する。
        messageSource.basenames = Holders.config.i18n.messageSource.additionalBasenames + originalBasenames
        messageSource.defaultEncoding = Holders.config.i18n.messageSource.defaultEncoding
    }
}
