package Algorithm;

public class ArticleAnnotation {
    public static String getNumeric(String str) {
        str = str.trim();
        StringBuilder str2 = new StringBuilder();
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ':') break;
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    str2.append(str.charAt(i));
                }
            }
        }
        return str2.toString();
    }

    public static void formatReference(String names) {
        String[] name = names.split("\n");
        for (int i = 0; i < name.length; i++) {
            String[] split = name[i].split("]");
            if (split.length <= 1) continue;
            int beginIndex = 0;
            if (split[1].indexOf('.') != -1) beginIndex = split[1].indexOf('.');
            String art_name = split[1].substring(beginIndex + 1, split[1].length() - 2);
            if (art_name.contains(","))
                art_name = art_name.substring(art_name.indexOf(",") + 1);
            if (split.length <= 2) continue;
            String art_info = split[2];
            String numeric = getNumeric(art_info);
            String art_time;
            if (numeric.length() > 4)
                art_time = numeric.substring(numeric.length() - 4);
            else
                art_time = numeric;
            String art_area;
            if (art_info.contains("NAACL")) art_area = "其他_CCFC";
            else if (art_info.contains("ACL") || art_info.contains("IJCAI") || art_info.contains("ICML") || art_info.contains(" ICCV"))
                art_area = "1区_CCFA";
            else if (art_info.contains("EMNLP")) art_area = "2区_CCFB";
            else if (art_info.contains("AAAI") || art_info.contains("NeurIPS") || art_info.toUpperCase().contains("NIPS")
            ) art_area = "2区_CCFA";
            else art_area = "其他_其他";
            System.out.println(art_time + "_" + art_area + "_" + art_name.trim().replace("-", "")
                    .replace(":", "").replace(" ", ""));
        }
    }

    public static void format(String names) {
        String[] name = names.split("\n");
        for (int i = 0; i < name.length; i++) {
            String[] split = name[i].split("\\(");
            if (split.length <= 1) continue;
            String art_name = split[0];
            String art_time = getNumeric(name[i]);
            String art_info = split[2];
            String art_area;
            if (art_info.indexOf("NAACL") != -1) art_area = "其他_CCFC";
            else if (art_info.indexOf("ACL") != -1 || art_info.indexOf("IJCAI") != -1 || art_info.indexOf("ICML") != -1
            ) art_area = "1区_CCFA";
            else if (art_info.indexOf("EMNLP") != -1) art_area = "2区_CCFB";
            else if (art_info.indexOf("AAAI") != -1 || art_info.indexOf("NeurIPS") != -1) art_area = "2区_CCFA";
            else art_area = "其他_其他";
            System.out.println(art_time + "_" + art_area + "_" + art_name.trim().replace("-", "")
                    .replace(":", "").replace(" ", ""));
        }
    }

    public static void main(String[] args) {
        ArticleAnnotation.formatReference(
                "[38] Jesse Dodge, Gabriel Ilharco, Roy Schwartz, Ali Farhadi,Hannaneh Hajishirzi, and Noah Smith. Fine-tuning pretrained language models: Weight initializations, data orders, and early stopping[C]. arXiv preprint arXiv:2002.06305, 2020.\n" +
                        "[39] Li Dong, Nan Yang, Wenhui Wang, Furu Wei, Xiaodong Liu, Yu Wang, Jianfeng Gao, Ming Zhou, and Hsiao-Wuen Hon. Unified language model pre-training for natural language un derstanding and generation[C]. In NeurIPS, pages 13042–13054,2019.\n" +
                        "[40] Zhen Dong, Zhewei Yao, Amir Gholami, Michael W Ma honey, and Kurt Keutzer. Hawq: Hessian aware quantization of neural networks with mixed-precision[C]. In ICCV, 2019.\n" +
                        "[41] Sergey Edunov, Alexei Baevski, and Michael Auli. Pre-trained language model representations for language generation[C]. In Jill Burstein, Christy Doran, and Thamar Solorio, editors,NAACL-HLT , 2019.\n" +
                        "[42] Julian Eisenschlos, Sebastian Ruder, Piotr Czapla, Marcin Kadras, Sylvain Gugger, and Jeremy Howard. MultiFiT: Effi-cient multi-lingual language model fine-tuning[C]. In EMNLP, 2019.\n" +
                        "[43] Dumitru Erhan, Yoshua Bengio, Aaron C. Courville, Pierre Antoine Manzagol, Pascal Vincent, and Samy Bengio. Why does unsupervised pre-training help deep learning?[J]. Journal of Machine Learning Research, 2010.\n" +
                        "[44] Allyson Ettinger. What BERT is not: Lessons from a new suiteof psycholinguistic diagnostics for language models[C]. TACL,8:34–48, 2020.\n" +
                        "[45] Manaal Faruqui and Chris Dyer. Improving vector space word representations using multilingual correlation[C]. In EACL, pages 462–471, 2014.\n" +
                        "[46] Prakhar Ganesh, Yao Chen, Xin Lou, Mohammad Ali Khan,Yin Yang, Deming Chen, Marianne Winslett, Hassan Sajjad,and Preslav Nakov. Compressing large-scale transformer based models: A case study on BERT[C]. arXiv preprint\n" +
                        "arXiv:2002.11985, 2020.\n" +
                        "[47] Matt Gardner, Joel Grus, Mark Neumann, Oyvind Tafjord,Pradeep Dasigi, Nelson F. Liu, Matthew Peters, Michael Schmitz, and Luke S. Zettlemoyer. Allennlp: A deep semantic natural language processing platform[C].NAACL,2017.\n" +
                        "[48] Siddhant Garg, Thuy Vu, and Alessandro Moschitti. Tanda:Transfer and adapt pre-trained transformer models for answer sentence selection[C]. In AAAI, 2019.\n" +
                        "[49] Jonas Gehring, Michael Auli, David Grangier, Denis Yarats, and Yann N Dauphin. Convolutional sequence to sequence learning[C]. In ICML 2017.\n" +
                        "[50] Yoav Goldberg. Assessing BERT’s syntactic abilities[C]. arXiv preprint arXiv:1901.05287, 2019.\n" +
                        "[51] Mitchell A Gordon, Kevin Duh, and Nicholas Andrews. Com pressing BERT: Studying the effects of weight pruning on transfer learning[C]. arXiv preprint arXiv:2002.08307, 2020.\n" +
                        "[52] Jian Guan, Fei Huang, Zhihao Zhao, Xiaoyan Zhu, and Minlie Huang. A knowledge-enhanced pretraining model for commonsense story generation[C]. arXiv preprint arXiv:2001.05139,2020.\n" +
                        "[53] Qipeng Guo, Xipeng Qiu, Pengfei Liu, Yunfan Shao, Xiangyang Xue, and Zheng Zhang. Star-transformer[C]. In NAACL,HLT, 2019.\n" +
                        "[54] Abhijeet Gupta, Gemma Boleda, Marco Baroni, and Sebastian\n" +
                        "Pado. Distributional vectors encode referential attributes[C]. In EMNLP, 2015.\n" +
                        "[55] Michael Gutmann and Aapo Hyvarinen. Noise-contrastive ¨estimation: A new estimation principle for unnormalized statistical models[C]. In AISTATS,2010.\n" +
                        "[56] Kai Hakala and Sampo Pyysalo. Biomedical named entity recognition with multilingual BERT. In BioNLP Open Shared Tasks[C].EMNLP, pages 56–61, 2019.\n" +
                        "[57] Hiroaki Hayashi, Zecong Hu, Chenyan Xiong, and Graham Neubig. Latent relation language models[C]. AAAI, 2019.\n");

    }
}
