import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import org.assertj.core.internal.Diff;
import org.junit.After;
import org.junit.Test;

import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.assertions.api.Assertions.assertThat;

import sample.Difficulty;
import sample.Main;
import sample.Monument;
import sample.Tower;

public class ControllerTestFXML {
    @Test
    public void testMonument() {
        Monument monument1 = new Monument();
        monument1.setHealthFromDifficulty(Difficulty.EASY);
        assertEquals(monument1.getHealth(), 500);
        Monument monument2 = new Monument();
        monument1.setHealthFromDifficulty(Difficulty.MEDIUM);
        assertEquals(monument1.getHealth(), 400);
        Monument monument3 = new Monument();
        monument1.setHealthFromDifficulty(Difficulty.HARD);
        assertEquals(monument1.getHealth(), 300);
    }

    @Test
    public void testTower() {
        Tower tower1 = new Tower();
        tower1.setName("Water Elemental");
        tower1.setPrice(250);
        assertEquals(tower1.getName(), "Water Elemental");
        assertEquals(250, tower1.getPrice(), 0);
        Tower tower2 = new Tower();
        tower1.setName("Earth Elemental");
        tower1.setPrice(300);
        assertEquals(tower1.getName(), "Earth Elemental");
        assertEquals(300, tower1.getPrice(), 0);
        Tower tower3 = new Tower();
        tower1.setName("Fire Elemental");
        tower1.setPrice(200);
        assertEquals(tower1.getName(), "Fire Elemental");
        assertEquals(200, tower1.getPrice(), 0);
        Tower tower4 = new Tower();
        tower1.setName("Air Elemental");
        tower1.setPrice(400);
        assertEquals(tower1.getName(), "Air Elemental");
        assertEquals(400, tower1.getPrice(), 0);
    }
}
