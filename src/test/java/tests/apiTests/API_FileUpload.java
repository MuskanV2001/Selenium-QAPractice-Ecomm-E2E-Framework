package tests.apiTests;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class API_FileUpload {

    @BeforeTest
    @Parameters({"apiBaseUrl"})
    public void baseUrlSetup(String apiBaseUrl){
        baseURI = apiBaseUrl;
        basePath = "";
    }

    @BeforeMethod
    public void consolePrint(){
        System.out.println("\n----------------------------------- NEW TEST STARTED -----------------------------------\n");
    }

    @Test(description = "File Uploading Test")
    public void fileUploadUsingAPI(){

        File fileToUpload = new File(System.getProperty("user.dir") + "/src/files/uploadFileText.txt");

        // Uploading the file
        Response response = given()
                .contentType("multipart/form-data")
                .multiPart("file", fileToUpload)
                .log().all()
                .when()
                .post("/files/upload");

        System.out.println(response.asPrettyString());

        // Fetching name of uploaded file
        String uploadedFilename = response.body().jsonPath().getString("filename");
        System.out.println("Uploaded Filename: " + uploadedFilename);

        // Getting the uploaded file using the filename
        response = given()
                .pathParam("fileName", uploadedFilename)
                .when()
                .get("/files/{fileName}");
        System.out.println("Downloaded File Content: " + response.asPrettyString());
    }
}
