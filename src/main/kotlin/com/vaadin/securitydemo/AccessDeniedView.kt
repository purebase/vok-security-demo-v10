package com.vaadin.securitydemo

import com.github.vok.karibudsl.flow.text
import com.github.vok.security.AccessRejectedException
import com.github.vok.security.AllowAll
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.*
import org.slf4j.LoggerFactory
import javax.servlet.http.HttpServletResponse

@PageTitle("Access Denied")
class AccessDeniedView : VerticalLayout(), HasErrorParameter<AccessRejectedException> {
    override fun setErrorParameter(event: BeforeEnterEvent, parameter: ErrorParameter<AccessRejectedException>): Int {
        log.error("Access denied", parameter.exception)
        text("Access denied: ${parameter.exception.message}")
        return HttpServletResponse.SC_FORBIDDEN
    }
    companion object {
        @JvmStatic
        private val log = LoggerFactory.getLogger(AccessDeniedView::class.java)
    }
}
