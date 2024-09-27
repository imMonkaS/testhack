FROM node:20.17.0-alpine AS prod

WORKDIR /app
COPY /src/main/frontend/package.json /app
RUN npm install
COPY /src/main/frontend/. /app
RUN npm run build
RUN npm install -g serve

EXPOSE 6702

CMD serve -s build -l 6702

# RUN npm run build
#
# #Stage 2
# FROM nginx:alpine
# WORKDIR /usr/share/nginx/html
# RUN rm -rf ./*
# COPY --from=prod /app/build .
# EXPOSE 7072
# ENTRYPOINT ["nginx", "-g", "daemon off;"]
