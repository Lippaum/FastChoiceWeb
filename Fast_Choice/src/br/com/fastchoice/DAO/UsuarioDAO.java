
package br.com.fastchoice.DAO;

import br.com.fastchoice.entity.Usuario;
import br.com.fastchoice.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author David
 */
public class UsuarioDAO {

    Session sessao;
    Transaction trans;
    List <Usuario> list;

    /**
     *
     * @return
     */
    public List<Usuario> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Usuario.class);
        this.list = cri.list();
        return list;
       
    }
    
    
    
    

    public void adicionarUsuario(Usuario c) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Usuario usuario = new Usuario();
            usuario.setUsuario(c.getUsuario());
            usuario.setEmail(c.getEmail());
            usuario.setSenha(c.getSenha());
            usuario.setConfSenha(c.getConfSenha());

            sessao.save(usuario);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void removerUsuario(Usuario c) {

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(c);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }
    
     public void editarUsuario(Usuario c) {

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.update(c);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }
}
