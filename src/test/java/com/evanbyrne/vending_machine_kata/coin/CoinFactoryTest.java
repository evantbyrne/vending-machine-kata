package com.evanbyrne.vending_machine_kata.coin;

import static org.junit.Assert.*;

import org.junit.Test;

import com.evanbyrne.vending_machine_kata.coin.Coin;
import com.evanbyrne.vending_machine_kata.coin.CoinFactory;

public class CoinFactoryTest {

    @Test
    public void testReadByName() {
        final Coin coinInvalid = CoinFactory.getByName("penny");
        assertNull( coinInvalid );

        final Coin coinNickel = CoinFactory.getByName("nickel");
        assertNotNull( coinNickel );
        assertEquals( 5, coinNickel.getCents() );

        final Coin coinDime = CoinFactory.getByName("Dime");
        assertNotNull( coinDime );
        assertEquals( 10, coinDime.getCents() );

        final Coin coinQuarter = CoinFactory.getByName("QUARTER");
        assertNotNull( coinQuarter );
        assertEquals( 25, coinQuarter.getCents() );
    }

    @Test
    public void testReadByDiameterAndWeight() {
        final Coin coinInvalidDiameter = CoinFactory.getByDiameterAndWeight(4, 1);
        assertNull( coinInvalidDiameter );

        final Coin coinInvalidWeight = CoinFactory.getByDiameterAndWeight(1, 4);
        assertNull( coinInvalidWeight );

        final Coin coinNickel = CoinFactory.getByDiameterAndWeight(Coin.NICKEL.getDiameter(), Coin.NICKEL.getWeight());
        assertNotNull( coinNickel );
        assertEquals( 5, coinNickel.getCents() );

        final Coin coinDime = CoinFactory.getByDiameterAndWeight(Coin.DIME.getDiameter(), Coin.DIME.getWeight());
        assertNotNull( coinDime );
        assertEquals( 10, coinDime.getCents() );

        final Coin coinQuarter = CoinFactory.getByDiameterAndWeight(Coin.QUARTER.getDiameter(), Coin.QUARTER.getWeight());
        assertNotNull( coinQuarter );
        assertEquals( 25, coinQuarter.getCents() );
    }

}
