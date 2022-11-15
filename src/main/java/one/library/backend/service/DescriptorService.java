package one.library.backend.service;

import one.library.backend.entity.Descriptor;
import one.library.backend.repository.DescriptorRepository;
import org.springframework.stereotype.Service;

@Service
public class DescriptorService {

    private final DescriptorRepository descriptorRepository;

    public DescriptorService(DescriptorRepository descriptorRepository) {
        this.descriptorRepository = descriptorRepository;
    }

    public Descriptor save(Descriptor descriptor) {
        return descriptorRepository.save(descriptor);
    }

}
