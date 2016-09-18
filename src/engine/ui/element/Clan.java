package engine.ui.element;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Wes on 9/18/2016.
 */
public final class Clan {
    /*********** United Sanctuary **********/
    public final int ROYAL_PALADIN = 0;
    public final int ORACLE_THINK_TANK = 1;
    public final int SHADOM_PALADIN = 2;
    public final int GOLD_PALADIN = 3;
    public final int ANGEL_FEATHER = 4;
    public final int GENESIS = 5;

    /*********** DRAGON EMPIRE **********/
    public final int KAGERO = 6;
    public final int NARUKAMI = 7;
    public final int TACHIKAZE = 8;
    public final int MURAKUMO = 9;
    public final int NUBATAMA = 10;

    /*********** DARK ZONE **********/
    public final int DARK_IREGULARS = 11;
    public final int PALE_MOON = 12;
    public final int GEAR_CHRONICLE = 13;
    public final int SPIKE_BROTHERS = 14;

    /*********** MAGALLANICA **********/
    public final int GRANBLUE = 15;
    public final int BERMUDA_TRIANGLE = 16;
    public final int AQUA_FORCE = 17;

    /*********** ZOO **********/
    public final int MEGACOLONY = 18;
    public final int GREAT_NATURE = 19;
    public final int NEO_NECTAR = 20;

    /*********** STAR GATE **********/
    public final int DIMENSION_POLICE = 21;
    public final int NOVA_GRAPPLER = 22;
    public final int LINK_JOKER = 23;

    private int clan;


    public Clan(int clan) {
        if(clan < 0 || clan > 24) {
            throw new IllegalArgumentException("Clan number (" + clan + ") given is not a valid clan number.");
        }

        this.clan = clan;
    }

    public String toString() {
        switch(this.clan) {
            case ROYAL_PALADIN:
                return "Royal Paladin";
            case ORACLE_THINK_TANK:
                return "Oracle Think Tank";
            case SHADOM_PALADIN:
                return "Shadow Paladin";
            case GOLD_PALADIN:
                return "Gold Paladin";
            case ANGEL_FEATHER:
                return "Angel Feather";
            case GENESIS:
                return "Genesis";
            case KAGERO:
                return "Kagero";
            case NARUKAMI:
                return "Narukami";
            case TACHIKAZE:
                return "Tachikaze";
            case MURAKUMO:
                return "Murakumo";
            case NUBATAMA:
                return "Nubatama";
            case DARK_IREGULARS:
                return "Dark Irregulars";
            case PALE_MOON:
                return "Pale Moon";
            case GEAR_CHRONICLE:
                return "Gear Chronicle";
            case SPIKE_BROTHERS:
                return "Spike Brothers";
            case GRANBLUE:
                return "Granblue";
            case BERMUDA_TRIANGLE:
                return "Bermuda Triangle";
            case AQUA_FORCE:
                return "Aqua Force";
            case MEGACOLONY:
                return "Megacolony";
            case GREAT_NATURE:
                return "Great Nature";
            case NEO_NECTAR:
                return "Neo Nectar";
            case DIMENSION_POLICE:
                return "Dimension Police";
            case NOVA_GRAPPLER:
                return "Nova Grappler";
            case LINK_JOKER:
                return "Link Joker";
            default:
                return "CLAN NOT RECOGNIZED";
        }
    }
}
