package br.com.senior.mydomain.myservice.repositories;

import br.com.senior.mydomain.myservice.MaquinaBaseRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public interface MaquinaRepository extends MaquinaBaseRepository, MaquinaRepositoryCustom {

}
