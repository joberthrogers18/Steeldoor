### STAGE 1: Build ###
FROM node:16-alpine AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
EXPOSE 4200
CMD ["npm","run","container"]
# RUN npm run build
# CMD [ "npm", "run", "start" ]

# ### STAGE 2: Run ###
# FROM nginx:1.25.1
# # COPY nginx.conf /etc/nginx/nginx.conf
# COPY --from=build /usr/src/app/dist/frontend /usr/share/nginx/html
