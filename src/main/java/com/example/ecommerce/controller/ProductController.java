@Controller
public class ProductController {
  @Autowired private ProductRepository productRepo;

  @GetMapping("/products")
  public String getProducts(Model model) {
    model.addAttribute("products", productRepo.findAll());
    return "products";
  }
}
