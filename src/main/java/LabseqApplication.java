import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "labseq application challenge",
                version = "1.0",
                contact = @Contact(
                        name = "Jonathan de Oliveira Alves Moreira",
                        email = "jonathan.oliveira16@yahoo.com.br"
                )
        )
)
public class LabseqApplication extends Application {
}
