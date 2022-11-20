package one.library.backend.service;

import one.library.backend.entity.Descriptor;
import one.library.backend.repository.DescriptorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DescriptorService {

    private final DescriptorRepository descriptorRepository;

    public DescriptorService(DescriptorRepository descriptorRepository) {
        this.descriptorRepository = descriptorRepository;
    }

    public Descriptor save(Descriptor descriptor) {
        return descriptorRepository.save(descriptor);
    }

    public ArrayList<Descriptor> getAll() {
        return (ArrayList<Descriptor>) descriptorRepository.findAll();
    }
}
