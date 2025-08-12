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
}
