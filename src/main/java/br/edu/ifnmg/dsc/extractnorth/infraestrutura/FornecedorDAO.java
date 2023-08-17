/*
 * package br.edu.ifnmg.dsc.extractnorth.infraestrutura;
 * 
 * import java.util.ArrayList;
 * 
 * import org.springframework.stereotype.Service;
 * 
 * import com.thoughtworks.qdox.model.expression.Query;
 * 
 * import br.edu.ifnmg.dsc.extractnorth.entidades.Fornecedor;
 * import br.edu.ifnmg.dsc.extractnorth.entidades.Pessoa;
 * import br.edu.ifnmg.dsc.extractnorth.servicos.FornecedorRepositorio;
 * 
 * @Service
 * public class FornecedorDAO extends DAO<Fornecedor> implements
 * FornecedorRepositorio {
 * 
 * public FornecedorDAO(Class<Fornecedor> classe) {
 * super(classe);
 * }
 * 
 * @Override
 * public Fornecedor abrirPorCPF(String cpf) {
 * Query consulta = (Query)
 * getManager().createQuery("select f from Fornecedor f where cpf = :p");
 * ((jakarta.persistence.Query) consulta).setParameter("p", cpf);
 * return (Fornecedor) ((jakarta.persistence.Query) consulta).getSingleResult();
 * }
 *
 * @Override
 * public ArrayList<Fornecedor> Buscar(Fornecedor filtro) {
 * String jpql = "select f from Fornecedor f join f.endereco e ";
 * String where = "";
 * ArrayList<Object> parametros = new ArrayList<>();
 *
 * if (filtro.getNome() != null || filtro.getNome() != "") {
 * where += "f.nome like CONCAT('%', :p1 , '%')";
 * parametros.add(filtro.getNome());
 * }
 *
 * if (filtro.getTelefone() != null || filtro.getTelefone() != "") {
 * if (where.length() > 0)
 * where += " and ";
 * where += " f.telefone = :p2 ";
 * parametros.add(filtro.getTelefone());
 * }
 *
 * if (filtro.getCpf() != null || filtro.getCpf() != "") {
 * if (where.length() > 0)
 * where += "and ";
 * where += "f.cpf = :p3 ";
 * parametros.add(filtro.getCpf());
 * }
 *
 * if (filtro.getEmail() != null || filtro.getEmail() != "") {
 * if (where.length() > 0)
 * where += "and ";
 * where += "f.email = :p4";
 * parametros.add(filtro.getEmail());
 * }
 *
 * if (((Fornecedor) filtro).getEndereco().getCidade() != null
 * || ((Fornecedor) filtro).getEndereco().getCidade() != "") {
 * if (where.length() > 0)
 * where += "and ";
 * where += "e.cidade = :p5 ";
 * parametros.add(((Pessoa) filtro).getEndereco().getCidade());
 * }
 *
 * String jpq = "";
 * if (where.length() > 0) {
 * jpq += " where " + where;
 * }
 *
 * jakarta.persistence.Query consulta = getManager().createQuery(jpql);
 * int ordem = 0;
 *
 * for (Object parametro : parametros) {
 * ordem++;
 * ((jakarta.persistence.Query) consulta).setParameter(ordem, parametro);
 * }
 *
 * return (ArrayList<Fornecedor>) ((jakarta.persistence.Query)
 * consulta).getResultList();
 *
 * }
 * 
 * }
 */