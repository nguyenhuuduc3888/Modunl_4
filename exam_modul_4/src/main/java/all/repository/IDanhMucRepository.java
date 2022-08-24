package all.repository;

import all.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDanhMucRepository extends JpaRepository<DanhMuc,Integer> {
}
