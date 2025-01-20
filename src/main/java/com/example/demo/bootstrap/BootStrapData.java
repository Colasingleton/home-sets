package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Cola's block start
        if(inhousePartRepository.count()==0){



        //parts

        InhousePart chair = new InhousePart();

        chair.setName("Arm Chair");
        chair.setInv(50);
        chair.setPrice(200.00);
        chair.setId(1);
        inhousePartRepository.save(chair);

        InhousePart rug =new InhousePart();

        rug.setName("Rug");
        rug.setInv(50);
        rug.setPrice(100.00);
        rug.setId(2);
        inhousePartRepository.save(rug);

        InhousePart lamp =new InhousePart();

        lamp.setName("Lamp");
        lamp.setInv(50);
        lamp.setPrice(50.00);
        lamp.setId(3);
        inhousePartRepository.save(lamp);

        }

        if(outsourcedPartRepository.count()==0){
        OutsourcedPart coffeeTable = new OutsourcedPart();

        coffeeTable.setName("Coffee Table");
        coffeeTable.setInv(50);
        coffeeTable.setPrice(100.00);
        coffeeTable.setId(4);
        outsourcedPartRepository.save(coffeeTable);

        OutsourcedPart mirror = new OutsourcedPart();

        mirror.setName("Mirror");
        mirror.setInv(50);
        mirror.setPrice(50.00);
        mirror.setId(5);
        outsourcedPartRepository.save(mirror);
        }


        //products

        if(productRepository.count()==0){

            Product livingRoomSet = new Product();
            livingRoomSet.setName("Lving Room Set");
            livingRoomSet.setInv(10);
            livingRoomSet.setPrice(500.00);
            livingRoomSet.setId(101);
            productRepository.save(livingRoomSet);

            Product bathroomSet = new Product();
            bathroomSet.setName("Bathroom Set");
            bathroomSet.setInv(10);
            bathroomSet.setPrice(500.00);
            bathroomSet.setId(102);
            productRepository.save(bathroomSet);

            Product bedroomSet = new Product();
            bedroomSet.setName("Bedroom Set");
            bedroomSet.setInv(10);
            bedroomSet.setPrice(500.00);
            bedroomSet.setId(103);
            productRepository.save(bedroomSet);

            Product kitchenSet = new Product();
            kitchenSet.setName("Kitchen Set");
            kitchenSet.setInv(10);
            kitchenSet.setPrice(500.00);
            kitchenSet.setId(104);
            productRepository.save(kitchenSet);

            Product diningRoomSet = new Product();
            diningRoomSet.setName("Dining Room Set");
            diningRoomSet.setInv(10);
            diningRoomSet.setPrice(500.00);
            diningRoomSet.setId(105);
            productRepository.save(diningRoomSet);

        }

        //Cola's block end




       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
