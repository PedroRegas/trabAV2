# 1. Divisão e Conquista

O problema pode ser resolvido por divisão e conquista, mas essa não é a forma mais eficiente. Isso é feito escolhendo uma requisição pivô e dividindo o conjunto em três partes:
 as que podem ocorrer antes dela as que podem ocorrer depois as que são incompatíveis. A solução é obtida recursivamente, comparando dois casos incluir o pivô ou excluir o pivô.
Essa abordagem leva à recorrência:
\
T(n)=2T(n-1)+O(n)
\
resultando em complexidade exponencial:
\
O(2^n)
\
o que a torna ineficiente para grandes entradas.

---

# 2. Estratégia Gulosa

O problema pode ser resolvido utilizando estratégia gulosa. Os critérios analisados foram:

## 2.1 Escolher a requisição que começa mais cedo

**Rejeitado**, pois uma requisição pode começar cedo, mas possuir longa duração, impedindo o processamento de requisições menores.

### Exemplo

| id | início | fim |
|----|---------|-----|
| 1  | 0       | 7   |
| 2  | 1       | 3   |
| 3  | 3       | 5   |

Nesse caso, apenas a primeira requisição seria processada.

---

## 2.2 Escolher a requisição de menor duração

**Rejeitado**.

Considere as seguintes requisições:


| id | início | fim |
|----|---------|-----|
| 1  | 4       | 6   |
| 2  | 2       | 5   |
| 3  | 5       | 8   |

Se escolhermos a requisição mais curta primeiro, apenas uma requisição será processada, em vez de duas.

---

## 2.3 Escolher a requisição que termina mais cedo

**Aceito**.

Esse critério libera o servidor o mais cedo possível, aumentando o tempo disponível para processar outras requisições.

---

# 3. Abordagem Escolhida

A abordagem escolhida é a **estratégia gulosa**, utilizando o critério de término mais cedo, pois ela garante a solução ótima global com eficiência:
\
O(n \log n)

sendo melhor que a abordagem de divisão e conquista:
\
O(2^n)

## Essa escolha é validada pelas seguintes propriedades:

#### Propriedade da Escolha Gulosa

Ao selecionar a requisição que termina primeiro, liberamos o servidor o mais cedo possível, deixando o máximo de tempo disponível para as próximas tarefas, sem prejudicar opções futuras.

#### Subestrutura Ótima

A solução global ideal é composta pela primeira escolha somada à solução ótima do subproblema restante (as tarefas que não conflitam com a primeira).

---

# 4. Passo a Passo do Algoritmo

1. Ordenar as requisições por tempo de término crescente.
2. Criar uma lista para armazenar a solução.
3. Criar uma variável para armazenar o tempo de término da requisição atual.
4. Percorrer a lista de requisições.
5. Para cada requisição, verificar se o tempo de início é maior ou igual ao tempo de término atual.
6. Caso seja, adicionar a requisição à lista de solução e atualizar o tempo de término atual.
