package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

        @Test
    public void eiNegatiivistaVarastoa() {
        varasto = new Varasto(-5);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
        @Test
    public void eiNegatiivistaVarastoaAlkusaldolla() {
        varasto = new Varasto(-5, 1.1);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
        @Test
    public void alkusaldollinenAlustusToimii() {
        varasto = new Varasto(5, 1.1);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(5, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
            @Test
    public void eiNegatiivistaAlkusaldoa() {
        varasto = new Varasto(5, -1.1);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
            @Test
    public void eiNegatiivistaLisaysta() {
        varasto = new Varasto(5, 1);
        varasto.lisaaVarastoon(-3);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(1, varasto.getSaldo(), vertailuTarkkuus);
    }

            @Test
    public void eiYlitäyteenLisaysta() {
        varasto = new Varasto(5, 1);
        varasto.lisaaVarastoon(5);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(5, varasto.getSaldo(), vertailuTarkkuus);
    }
    
                @Test
    public void toStringToimii() {
        varasto = new Varasto(5, 1);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals("saldo = 1.0, vielä tilaa 4.0", varasto.toString());
    }

            @Test
    public void eiVoiOttaaNegatiivistaMaaraa() {
        varasto = new Varasto(5, 2);
        varasto.otaVarastosta(-2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(2, varasto.getSaldo(), vertailuTarkkuus);
    }
    
}