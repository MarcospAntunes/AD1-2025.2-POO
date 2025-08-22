package src.model;

public class Medalhas {
  private int ouro;
  private int prata;
  private int bronze;

  public Medalhas() {
    this.bronze = 0;
    this.prata = 0;
    this.ouro = 0;
  }

  public void ganharOuro() { ouro += 1; }
  public void ganharPrata() { prata += 1; }
  public void ganharBronze() { bronze += 1; }

  public int getOuro() { return ouro; }
  public int getPrata() { return prata; }
  public int getBronze() { return bronze; }

  public int getPontos() {
    return (ouro * 10) + (prata * 8) + (bronze * 6);
  }

  @Override
  public String toString() {
    return "Ouro: " + ouro + " | Prata: " + prata + " | Bronze: " + bronze + " | Pontos: " + getPontos();
  }
}
