
package br.com.fastchoice.bean;

import br.com.fastchoice.DAO.UsuarioDAO;
import br.com.fastchoice.entity.Usuario;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author David
 */
@ManagedBean
@SessionScoped
public class UsuariosBean {

    private Usuario usuario = new Usuario();
    public UsuarioDAO usuarioDao = new UsuarioDAO();
    List<Usuario> listaUsuarios;
    
    
    public List listaUsuarios(){
      listaUsuarios =  usuarioDao.getList();
      return this.listaUsuarios;
    }
    
    public UsuariosBean() {
    
    }
    
    public String adicionarUsuario (){
       usuarioDao.adicionarUsuario(usuario);
       usuario.setUsuario(null);
       usuario.setEmail(null);
       usuario.setSenha(null);
       usuario.setConfSenha(null);
        return "index";
    }

     public String removerUsuario (Usuario c){
       this.usuario = c;
       usuarioDao.removerUsuario(this.usuario);
       this.usuario.setUsuario("");
       this.usuario.setEmail("");
       this.usuario.setSenha("");
       this.usuario.setConfSenha("");
       return "index";
    }
     
    /**
     *
     * @param c
     * @return
     */
    
     public String atualizarUsuario(){
         usuarioDao.editarUsuario(usuario);
         usuario.setUsuario(null);
         usuario.setEmail(null);
         usuario.setSenha(null);
         usuario.setConfSenha(null);
         return "index";
     }
     
     public String carregarUsuario(Usuario c){
        this.usuario = c;
         return "editar";
         
        }
     
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuariosBean other = (UsuariosBean) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
}
