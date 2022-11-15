package one.library.backend.repository;

import one.library.backend.entity.Descriptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptorRepository extends JpaRepository<Descriptor, Integer> {
}
