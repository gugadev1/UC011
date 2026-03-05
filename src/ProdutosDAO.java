/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    private String ultimoErro;

    public String getUltimoErro() {
        return ultimoErro;
    }
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        ultimoErro = null;

        if (produto == null) {
            ultimoErro = "Produto inválido para cadastro.";
            return false;
        }

        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            ultimoErro = "Nome do produto é obrigatório.";
            return false;
        }

        if (produto.getValor() == null || produto.getValor() <= 0) {
            ultimoErro = "Valor do produto deve ser maior que zero.";
            return false;
        }

        try {
            conn = new conectaDAO().connectDB();
            if (conn == null) {
                ultimoErro = "Não foi possível conectar ao banco de dados.";
                return false;
            }
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            return prep.executeUpdate() > 0;
        } catch (SQLException erro) {
            ultimoErro = erro.getMessage();
            return false;
        } catch (Exception erro) {
            ultimoErro = erro.getMessage();
            return false;
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException erro) {
            }
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        String sql = "SELECT id, nome, valor, status FROM produtos";
        listagem = new ArrayList<>();
        ultimoErro = null;

        try {
            conn = new conectaDAO().connectDB();
            if (conn == null) {
                ultimoErro = "Não foi possível conectar ao banco de dados.";
                return listagem;
            }
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                listagem.add(produto);
            }
        } catch (SQLException erro) {
            ultimoErro = erro.getMessage();
        } catch (Exception erro) {
            ultimoErro = erro.getMessage();
        } finally {
            try {
                if (resultset != null) {
                    resultset.close();
                }
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException erro) {
            }
        }

        return listagem;
    }

    public boolean venderProduto(int idProduto) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        ultimoErro = null;

        if (idProduto <= 0) {
            ultimoErro = "ID do produto inválido.";
            return false;
        }

        try {
            conn = new conectaDAO().connectDB();
            if (conn == null) {
                ultimoErro = "Não foi possível conectar ao banco de dados.";
                return false;
            }

            prep = conn.prepareStatement(sql);
            prep.setInt(1, idProduto);

            return prep.executeUpdate() > 0;
        } catch (SQLException erro) {
            ultimoErro = erro.getMessage();
            return false;
        } catch (Exception erro) {
            ultimoErro = erro.getMessage();
            return false;
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException erro) {
            }
        }
    }

    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        String sql = "SELECT id, nome, valor, status FROM produtos WHERE status = 'Vendido'";
        listagem = new ArrayList<>();
        ultimoErro = null;

        try {
            conn = new conectaDAO().connectDB();
            if (conn == null) {
                ultimoErro = "Não foi possível conectar ao banco de dados.";
                return listagem;
            }

            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                listagem.add(produto);
            }
        } catch (SQLException erro) {
            ultimoErro = erro.getMessage();
        } catch (Exception erro) {
            ultimoErro = erro.getMessage();
        } finally {
            try {
                if (resultset != null) {
                    resultset.close();
                }
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException erro) {
            }
        }

        return listagem;
    }
    
    
    
        
}

