import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("sentinel")
   CacheableNode sentinel;

   public Node2LinkedList() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   @Export("push")
   public void push(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgh;)V"
   )
   @Export("setHead")
   public void setHead(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   @Export("pop")
   CacheableNode pop() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.unlinkDual();
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lgh;"
   )
   @Export("peek")
   public CacheableNode peek() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("x")
   @Export("clear")
   void clear() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.unlinkDual();
      }
   }
}
