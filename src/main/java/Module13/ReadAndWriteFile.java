package Module13;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class ReadAndWriteFile {

    public ReadAndWriteFile(int userId) throws IOException {

        String url = "https://jsonplaceholder.typicode.com/users/"+userId+"/posts";
        String response = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken
                .getParameterized(List.class, Posts.class)
                .getType();

        List<Posts> PostsResponses = new Gson().fromJson(response, type);

        PostsResponses = PostsResponses.stream()
                .sorted((o1, o2) -> o2.getId()-o1.getId())
                .limit(1)
                .collect(Collectors.toList());

        WriteFileJson(userId, PostsResponses.get(0).getId());

    }

    public void WriteFileJson(int userId, int postID) throws IOException {

        String url = "https://jsonplaceholder.typicode.com/posts/"+postID+"/comments";
        String response = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken
                .getParameterized(List.class, Comments.class)
                .getType();
        List<Comments> CommentsResponses = new Gson().fromJson(response, type);

        CommentsResponses = CommentsResponses.stream()
                .filter(item -> item.getPostId() == postID)
                .collect(Collectors.toList());


        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter fw = new FileWriter("user-"+userId+"-post-"+postID+"-comments.json");
        gson.toJson(CommentsResponses,fw);
        fw.flush();
        fw.close();
    }
}
