package Module13;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Lab13_1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        User user = CreateDefaultUser();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpPost(user, client);
        HttpPut(user, client, "10");
        HttpDelete(user, client, "10");
        HttpGET(user, client);
        HttpGETId(user, client, "7");
        HttpGETName(user, client, "Delphine");

    }

    public static User CreateDefaultUser(){

        User user = new User();
        user.setName("Aleksey Pylypenko");
        user.setUsername("Still");
        user.setEmail("Still100584@gmail.com.com");
        user.setAdress(new Adress("Ukrainska", "61", "Kryviy Ryh", "50000",
                new Geo (23.3456, 43.3455)));
        user.setPhone("099-255-255-45");
        user.setWebsite("POV.net");
        user.setCompany(new Company("POV&Co", "Proactive didactic contingency", "Synergize scalable supply-chains"));
        return user;
    }
    public static void HttpPost(User user, HttpClient client) throws IOException, InterruptedException {

        String url = "https://jsonplaceholder.typicode.com/users";

        Gson gson = new Gson();
        String json = gson.toJson(user);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response_POST.statusCode() = " + response.statusCode());

        System.out.println("response_POST.body() = " + response.body());
    }

    public static void HttpPut(User user, HttpClient client, String number) throws IOException, InterruptedException {

        String url = "https://jsonplaceholder.typicode.com/users/"+number;
        user.setUsername("Still");
        Gson gson = new Gson();
        String json = gson.toJson(user);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response_PUT.statusCode() = " + response.statusCode());

        System.out.println("response_PUT.body() = " + response.body());
    }

    public static void HttpDelete (User user, HttpClient client, String number) throws IOException, InterruptedException {

        String url = "https://jsonplaceholder.typicode.com/users/"+number;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response_Delete.statusCode() = " + response.statusCode());
    }

    public static void HttpGET(User user, HttpClient client) throws IOException, InterruptedException {

        String url = "https://jsonplaceholder.typicode.com/users";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response_GET.statusCode() = " + response.statusCode());

        System.out.println("response_GET.body() = " + response.body());
    }

    public static void HttpGETId(User user, HttpClient client, String number) throws IOException, InterruptedException {

        String url = "https://jsonplaceholder.typicode.com/users/" + "?id="+number;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response_GET_id.statusCode() = " + response.statusCode());

        System.out.println("response_GET_id.body() = " + response.body());
    }

    public static void HttpGETName(User user, HttpClient client, String name) throws IOException, InterruptedException {

        String url = "https://jsonplaceholder.typicode.com/users/"+"?username="+name;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type","application/json")
            .GET()
            .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response_GET_username.statusCode() = " + response.statusCode());

        System.out.println("response_GET_username.body() = " + response.body());
    }
}
