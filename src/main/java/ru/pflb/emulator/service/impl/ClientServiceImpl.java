package ru.pflb.emulator.service.impl;

import org.apache.coyote.Response;
import org.springframework.stereotype.Service;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public ClientDto getUserById(long id) {
        //some code
        Random random=new Random();
        ClientDto client = ClientDto.builder()
                .id(id)
                .firstName(randStr(23,65))
                .lastName(randStr(23,65))
                .cardNumber(randStr(10,48))
                .isActive(randBool())
                .INN(randStr(10,48))
                .scanLink(getFilesList().get(random.nextInt(getFilesList().size())))
                .build();
        return client;//null;
    };


    public String randStr(int k,int j){
        StringBuilder s= new StringBuilder("0123456789");
        for (int i=0;i<10;i++){
            Random random = new Random();
            s.setCharAt(i,(char)(random.nextInt(k)+j));
        }
        return s.toString();
    };

    public boolean randBool(){
        Random random = new Random();
        if (random.nextInt(100)<50){
            return true;
        }else{
            return false;
        }
    }



    public static List<String> getFilesList() {

        final File folder = new File("src/main/resources");

        List<String> result = new ArrayList();

        search(".*", folder, result);

        for (String s : result) {
            System.out.println(s);
        }
        return result;
    }

    public static void search(final String pattern, final File folder, List<String> result) {
        for (final File f : folder.listFiles()) {

            if (f.isDirectory()) {
                search(pattern, f, result);
            }

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                }
            }

        }
    }


}
