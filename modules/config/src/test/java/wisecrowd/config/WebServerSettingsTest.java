package wisecrowd.config;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WebServerSettingsTest {

    @Test
    public void webServerSettings_portForSite_5555() {
        WebServerSettings settings = new WebServerSettings(WebServerType.SITE);
        assertThat(settings.getPort()).isEqualTo(5555);
    }

    @Test
    public void webServerSettings_portForAdmin_5556() {
        WebServerSettings settings = new WebServerSettings(WebServerType.ADMIN);
        assertThat(settings.getPort()).isEqualTo(5556);
    }

    @Test
    public void webServerSettings_numberOfServerThreads_five() {
        WebServerSettings settings = new WebServerSettings(WebServerType.SITE);
        assertThat(settings.numberOfServerThreads()).isEqualTo(5);
    }

    @Test
    public void webServerSettings_forceHttps_false() {
        WebServerSettings settings = new WebServerSettings(WebServerType.SITE);
        assertThat(settings.forceHttps()).isFalse();
    }


    @Test
    public void webServerSettings_cacheFilesInRam_false() {
        WebServerSettings settings = new WebServerSettings(WebServerType.SITE);
        assertThat(settings.cacheFilesInRam()).isFalse();
    }

    @Test
    public void webServerSettings_useLogger_false() {
        WebServerSettings settings = new WebServerSettings(WebServerType.SITE);
        assertThat(settings.useLogger()).isFalse();
    }

    @Test
    public void webServerSettings_isProduction_false() {
        assertThat(WebServerSettings.isProduction()).isFalse();
    }

    @Test
    public void webServerSettings_isStaging_false() {
        assertThat(WebServerSettings.isStaging()).isFalse();
    }

    @Test
    public void webServerSettings_isDevelopment_true() {
        assertThat(WebServerSettings.isDevelopment()).isTrue();
    }


    @Test
    public void webServerSettings_getEnvironment_development() {
        assertThat(WebServerSettings.getEnvironment()).isEqualTo("development");
    }
}
