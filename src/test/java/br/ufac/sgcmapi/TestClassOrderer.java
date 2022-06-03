package br.ufac.sgcmapi;

import java.util.Comparator;

import org.junit.jupiter.api.ClassDescriptor;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.ClassOrdererContext;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

public class TestClassOrderer implements ClassOrderer {

    @Override
    public void orderClasses(ClassOrdererContext context) {
        context.getClassDescriptors().sort(
            Comparator.comparingInt(TestClassOrderer::getOrder)
        );
    }

    private static int getOrder(ClassDescriptor descriptor) {
        if (descriptor.findAnnotation(SpringBootTest.class).isPresent()) {
            if (descriptor.getDisplayName().equals("SgcmapiApplicationTests")) {
                return 2;
            }
            return 3;
        } else if (descriptor.findAnnotation(WebMvcTest.class).isPresent()) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
