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
            String art_info = split[2];
            String art_time = getNumeric(art_info);
            String art_area;
            if (art_info.contains("NAACL")) art_area = "其他_CCFC";
            else if (art_info.contains("ACL") || art_info.contains("IJCAI") || art_info.contains("ICML")
            ) art_area = "1区_CCFA";
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
                "[1] SHI, Xiaoming, et al. Understanding Medical Conversations with Scattered Keyword Attention and Weak Supervision from Responses[C]. AAAI, 2020. \n" +
                        "[2] Zhiguo Wang,Multi-passage BERT: A Globally Normalized BERT Model for Open-domain Question Answering[C]. ACL, 2019.\n" +
                        "[3] Wang Y , Che W , Guo J , et al. Cross-Lingual BERT Transformation for Zero-Shot Dependency Parsing[C]. EMNLP, 2019.\n" +
                        "[4] Garg S , Vu T , Moschitti A . TANDA: Transfer and Adapt Pre-Trained Transformer Models for Answer Sentence Selection[C]. AAAI, 2019.\n" +
                        "[5] Cui Y, Che W, Zhang W, et al. Discriminative Sentence Modeling for Story Ending Prediction[C]. AAAI, 2020.\n" +
                        "[6] Feng X, Sun Y, Qin B, et al. Learning to Select Bi-Aspect Information for Document-Scale Text Content Manipulation[C]. AAAI, 2020.\n" +
                        "[7] Wang Y, Che W, Guo J, et al. Cross-Lingual BERT Transformation for Zero-Shot Dependency Parsing[C]. IJCNLP, 2019: 5720-5726.\n" +
                        "[8] Andor D , He L , Lee K , et al. Giving BERT a Calculator: Finding Operations and Arguments with Reading Comprehension[C]. EMNLP, 2019.\n" +
                        "[9] Cui Y, Che W, Liu T, et al. Cross-Lingual Machine Reading Comprehension[C]. IJCNLP, 2019: 1586-1595.\n" +
                        "[10] Song K , Tan X , Qin T , et al. MASS: Masked Sequence to Sequence Pre-training for Language Generation[C]. ICML,2019.\n" +
                        "[11] Shaolei Wang, et al.Multi-Task Self-Supervised Learning for Disfluency Detection[C]. AAAI,2020.\n" +
                        "[12] Cui Y , Che W , Liu T , et al. Cross-Lingual Machine Reading Comprehension[C]. EMNLP,2019.\n" +
                        "[13] Single-/Multi-Source Cross-Lingual NER via Teacher-Student Learning on Unlabeled Data in Target Language[C]. ACL,2019.\n" +
                        "[14] Vaswani A, Shazeer N, Parmar N, et al. Attention is All you Need[C]. NIPS, 2017: 5998-6008.\n");

    }
}
