package Main;

import lucene.Indexer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

public class main {
    public static void main(String[] args) throws IOException {

        /*
        String dataSet_path = "/home/leonardo/IdeaProjects/socialMining/src/main/java/Main/dataset_new.gz";
        DatasetIndexer.indexDataSet(dataSet_path);
         */

        ArrayList<ArrayList<Document>> windows = WindowGeneratorByDay.getSlidingWindows(30, 100);
        System.out.println(windows.get(0).size());

    }
}
