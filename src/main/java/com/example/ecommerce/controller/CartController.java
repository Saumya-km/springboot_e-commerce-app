@Controller
public class CartController {
  @Autowired private CartItemRepository cartRepo;
  @Autowired private ProductRepository productRepo;
  @Autowired private UserRepository userRepo;

  @PostMapping("/cart/add")
  public String addToCart(@RequestParam Long productId, Principal principal) {
    User user = userRepo.findByUsername(principal.getName());
    Product product = productRepo.findById(productId).get();
    
    CartItem item = new CartItem();
    item.setUser(user);
    item.setProduct(product);
    item.setQuantity(1);
    cartRepo.save(item);
    
    return "redirect:/cart";
  }

  @GetMapping("/cart")
  public String viewCart(Model model, Principal principal) {
    User user = userRepo.findByUsername(principal.getName());
    model.addAttribute("items", cartRepo.findByUser(user));
    return "cart";
  }
}
