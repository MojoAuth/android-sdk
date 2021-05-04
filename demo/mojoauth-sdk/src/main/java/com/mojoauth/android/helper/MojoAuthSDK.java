package com.mojoauth.android.helper;


import java.util.Map;
import java.util.TreeMap;

public class MojoAuthSDK {

    private static String MOJOAUTH_API_ROOT = "https://api.mojoauth.com";
    private MojoAuthSDK() {}

    public static class Initialize{
        private static String apiKey,domain;

        public void setApiKey(String apiKey) {
            Initialize.apiKey = apiKey;
        }



    }

    public static boolean validate(){
        if(Initialize.apiKey == null || Initialize.apiKey.length() == 0){
            return false;
        }else return true;
    }

    public static String getApiKey() {
        return Initialize.apiKey;
    }



    public static String getApiDomain() {
        if(Initialize.domain!=null && Initialize.domain.length() > 0){
            return Initialize.domain;
        }else{
            return MOJOAUTH_API_ROOT;
        }
    }






    public static class InitializeException extends RuntimeException{
        public InitializeException() {
            super("MojoAuth SDK not initialized properly");
        }
    }

    public static String GetRequestUrl(String url, Map<String, String> queryArgs) {
        String keyvalueString = createKeyValueString(queryArgs);
        if (url.contains("?"))
            return url + "&" + keyvalueString;

        return url + "?" + keyvalueString;
    }


    public static String createKeyValueString(Map<String, String> queryArgs) {
        if (queryArgs != null) {
            String[] sb = new String[queryArgs.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : queryArgs.entrySet()) {
                sb[i] = entry.getKey() + "=" + entry.getValue();
                i++;
            }
            return combine(sb, "&");
        } else
            return null;
    }


    public static String combine(String[] s, String glue) {
        int k = s.length;
        if (k == 0)
            return null;
        StringBuilder out = new StringBuilder();
        out.append(s[0]);
        for (int x = 1; x < k; ++x)
            out.append(glue).append(s[x]);
        return out.toString();
    }


    public static String getFinalPath(String path, Map<String, String> map) {
        String finalPath = path;
        Map<String, String> data = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        if (map != null && !map.isEmpty()) {
            data.putAll(map);
        }
        if (isPlaceholders(path)) {
            finalPath = replacePlaceholders(path, data);
        }
        return finalPath;
    }

    private static Boolean isPlaceholders(String path) {
        return path.contains("{{") && path.contains("}}");
    }


    private static String replacePlaceholders(String path, Map<String, String> data) {
        String res = path;
        String[] arr = res.split("/");
        for (int i = 0; i < arr.length; i++) {
            if (isPlaceholders(arr[i])) {
                String field = arr[i].substring(arr[i].indexOf("{{") + 2, arr[i].indexOf("}}"));
                arr[i] = data.get(field);
            }
        }
        return join(arr);
    }

    private static String join(String[] arr) {
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
            if (i != arr.length - 1) {
                res += "/";
            }
        }
        return res;
    }
}
