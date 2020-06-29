package id.co.jasindo.mailservices.repos;

import id.co.jasindo.mailservices.entity.Mailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.nio.channels.FileChannel;
import java.util.List;

public interface MailerRepository extends JpaRepository<Mailer, Integer> {
    @Query(value = "SELECT * FROM tb_mailer WHERE no_dokumen IN (:noDokumen)", nativeQuery = true)
    List<Mailer> findByNoDokumen(List<String> noDokumen);
}
