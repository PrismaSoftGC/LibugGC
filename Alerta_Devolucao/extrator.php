<?php

/*
Gabriel/Walter
Preciso que monte a conexao deste select passando o valor para essas variaveis
Select: SELECT nome, email, devolucao FROM cliente INNER join emprestimo on cliente.codigoCliente = emprestimo.codigoCliente

Ai voce joga em um vetor, que compara a data atual e ve se ela é um dia antes da data de devolucao, se ela for, passa os valores para as variaves e inicia
a funcao mail, caso nao for... ai voces coloca para dar stop na execucao do php.

Se nao entender chama no zap apos as 04:00 da manha...
*/




/*
//variaveis locais recebendo os valores do banco 
$email = $email;
$nome = $nome;
$devolucao = $devolucao;
*/

$para = "to:$email";
$assunto = "PrismaSoft - Alerta de Devolução";
$mensagem = "Olá, $nome voce tem devolução que vence amanha($dataDevolucao), evite pagar multas e faça a devolução.";
$cabecalho = "MIME-Version: 1.0" . "\r\n";
$cabecalho .= "Content-type: text/html; charset=ISO 8859-1" . "\r\n";
$cabecalho .= "from: prismasoftgc<prismasoftgc@gmail.com>" . "\r\n" . "Reply-to: prismasoftgc@gmail.com" . "\r\n";

mail($para, $assunto, $mensagem, $cabecalho);
echo "Email enviado com sucesso.";
?>