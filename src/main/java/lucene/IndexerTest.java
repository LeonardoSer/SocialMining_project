package lucene;

public class IndexerTest {

    public static void main(String [] args) throws Throwable{

        IDcard[] cards = new IDcard[2];

        cards[0] = new IDcard();
        cards[0].Tag = "PROSTATAMARCIA";
        cards[0].Name = "CappellanoJhonny";
        cards[0].Bio = "sono nato con il culo al contrario";
        cards[0].Bdate = 26121998L;
        cards[0].Height = 1.2;

        cards[1] = new IDcard();
        cards[1].Tag = "UNAPOMPA5EURO";
        cards[1].Name = "DoraDaccelancora";
        cards[1].Bio = "vivo col gay e saranno cazzi miei";
        cards[1].Bdate = 69420000L;
        cards[1].Height = 3.0;

        Indexer idx = new Indexer();
        idx.indexing(cards);

        System.out.println("index finito!");




    }
}
