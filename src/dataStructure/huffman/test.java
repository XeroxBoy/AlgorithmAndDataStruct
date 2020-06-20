package dataStructure.huffman;

import java.io.File;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HuffmanCompress sample = new HuffmanCompress();
        File inputFile = new File("E:\\Sogou-News-Text-Classification\\CN_Corpus\\news.sohunews.340806.txt");
        File outputFile = new File("E:\\sohunews.rar");
        sample.compress(inputFile, outputFile);
//        File inputFile = new File("C:\\Users\\long452a\\Desktop\\opencv链接文档.rar");
//        File outputFile = new File("C:\\Users\\long452a\\Desktop\\opencv链接文档1.txt");
//        sample.extract(inputFile, outputFile);
    }

}
