package com.mycompany.app;

import static java.nio.charset.StandardCharsets.UTF_8;
import com.google.gcloud.storage.StorageOptions;
import com.google.gcloud.storage.Storage;
import com.google.gcloud.storage.Blob;
import com.google.gcloud.storage.BlobId;
import com.google.gcloud.storage.BlobInfo;
import com.google.gcloud.AuthCredentials;
import java.io.FileInputStream;
import java.io.IOException;


public class App 
{
    /*
       params:
         args[0]: path to service account private key (json format)
         args[1] bucket name
      */

    public static void main( String[] args )
    {
        try {
            Storage storage = StorageOptions.builder().authCredentials(AuthCredentials.createForJson(new FileInputStream(args[0]))).build().service();
            BlobId blobId = BlobId.of(args[1], "helloworld.txt");
            BlobInfo blobInfo = BlobInfo.builder(blobId).contentType("text/plain").build();
            Blob blob = storage.create(blobInfo, "Hello, Cloud Storage!".getBytes(UTF_8));
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
