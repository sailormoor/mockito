package sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

public class MessageSenderTest {
    @Test
    void testRusMock(){
        GeoService geo = Mockito.mock(GeoService.class);
        LocalizationService loc = Mockito.mock(LocalizationService.class);
        Mockito.when(geo.byIp(Mockito.startsWith("172.")))
                .thenReturn(new Location("RusCity", Country.RUSSIA, null, 0));
        Mockito.when(geo.byIp(Mockito.startsWith("96.")))
                .thenReturn(new Location("USACity", Country.USA, null, 0));

        Mockito.when(loc.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать!");
        Mockito.when(loc.locale(Country.USA))
                .thenReturn("Welcome!");
    }
}
