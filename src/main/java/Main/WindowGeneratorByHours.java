package Main;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class WindowGeneratorByHours {

    public static ArrayList<Document> windowAppender(String month, String day, ArrayList<Document> result, String startHour) throws IOException{

        String real_hour = startHour;

        for(int i = Integer.parseInt(startHour); i < 120; i++) {

            if(real_hour.length() == 1){
                real_hour = "0" + real_hour;
            }

            IndexReader ir;
            Directory dir = new SimpleFSDirectory(FileSystems.getDefault().getPath("tweets_index"));
            ir = DirectoryReader.open(dir);

            IndexSearcher searcher = new IndexSearcher(ir);

            PhraseQuery.Builder builder = new PhraseQuery.Builder();
            builder.add(new Term("created_at", month), 1);
            builder.add(new Term("created_at", day), 2);
            builder.add(new Term("created_at", real_hour), 3);

            PhraseQuery q = builder.build();


            TopDocs top = searcher.search(q, ir.numDocs());
            ScoreDoc[] hits = top.scoreDocs;

            Document doc = null;
            for (ScoreDoc entry : hits) {
                doc = searcher.doc(entry.doc);
                result.add(doc);
            }

            if(i == 119 ){
                System.out.println(real_hour);
            }

            real_hour = Integer.toString(Integer.parseInt(real_hour)+1);

            if(i % 24 == 0){
                real_hour = Integer.toString(0);
                day = Integer.toString(Integer.parseInt(day)+1);
                if(day.equals("31")){
                    day = "1";
                    month = "feb";
                }
            }
        }

        return result;
    }

}
