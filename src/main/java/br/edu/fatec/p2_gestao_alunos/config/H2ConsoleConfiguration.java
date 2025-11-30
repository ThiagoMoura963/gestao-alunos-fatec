package br.edu.fatec.p2_gestao_alunos.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Servlet;

@Configuration
@ConditionalOnProperty(name = "spring.h2.console.enabled", havingValue = "true")
public class H2ConsoleConfiguration {

    @Bean
    public ServletRegistrationBean<Servlet> h2ConsoleServletRegistration() {
        try {
            Class<?> webServletClass = Class.forName("org.h2.server.web.JakartaWebServlet");
            Servlet servlet = (Servlet) webServletClass.getDeclaredConstructor().newInstance();
            ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<>(servlet, "/h2-console/*");
            registration.setName("H2Console");
            return registration;
        } catch (Exception e) {
            // Se não encontrar a classe JakartaWebServlet, tenta a versão antiga
            try {
                Class<?> webServletClass = Class.forName("org.h2.server.web.WebServlet");
                Servlet servlet = (Servlet) webServletClass.getDeclaredConstructor().newInstance();
                ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<>(servlet, "/h2-console/*");
                registration.setName("H2Console");
                return registration;
            } catch (Exception ex) {
                throw new RuntimeException("Não foi possível registrar o servlet do H2 Console", ex);
            }
        }
    }
}